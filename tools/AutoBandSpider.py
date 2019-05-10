# -*- coding:utf-8 -*-
# coding:utf-8

import io
import os
import pymysql
import re
import sys
import urllib
import urllib2
import urlparse
from bs4 import BeautifulSoup


class CatSpider():

    def __init__(self):
        self.siteURL = 'https://www.autohome.com.cn/grade/carhtml/'

        self.headers = {'User-Agent': 'Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0'}
        self.brand_list = []

    #
    def postData(self, url):
        request = urllib2.Request(url, headers=self.headers)
        response = urllib2.urlopen(request)
        html = response.read()
        return html

    #
    def getData(self, html):
        soup = BeautifulSoup(html, "html.parser")
        # print soup.prettify()
        dl_list = soup.select('dl')
        brand_list = []

        for i in range(len(dl_list)):
            brand = {}
            brand['initials'] = self.initials
            # tmp = filter(None, dl_list[i].contents)
            tmp = dl_list[i].select("dt")
            brand_data = tmp[0].select("a")

            pic_url = "https:" + brand_data[0].select("img")[0].attrs["src"].encode('ascii')
            self.writeFilesImg(pic_url)
            brand["pic_url"] = self.writeFilesImg(pic_url)
            brand["name"] = brand_data[1].string.encode('unicode_escape').decode('string_escape')

            cat_type_data = dl_list[i].select("dd ul li")
            car = []
            # print cat_type_data
            # print type(cat_type_data)
            # print len(cat_type_data)
            # exit()
            for li in cat_type_data:
                # print type(li)
                # print li
                # exit()
                if li.select("h4") == []:
                    continue

                car_type = {}
                car_type["name"] = li.select("h4 a")[0].string

                cat_type_data_div_pic_url = "https:" + li.select("div a img")[0].attrs["src"]
                print
                "Get url:" + cat_type_data_div_pic_url

                car_type["pic_url"] = self.writeFilesImg(cat_type_data_div_pic_url, '/images/cartype')
                car.append(car_type)
                # print car_type
                # exit()
            brand["types"] = car
            brand_list.append(brand)
        return brand_list

    #
    def setPostString(self):
        initials_list = [chr(i).upper() for i in range(97, 123)]
        return initials_list

    def mkImagesDir(self, dir_string=""):
        if dir_string == "":
            dir_string = '/images/brand'
        folder = os.getcwd() + dir_string
        print
        "Picture save directory:"
        print
        folder
        if not os.path.exists(folder):
            res = os.makedirs(folder, 777)
        return folder

    def writeFilesImg(self, img_url, dir_string='/images/brand'):
        folder = self.mkImagesDir(dir_string)
        cat_img = self.postData(img_url)
        tmp_img_url = img_url.split('/')
        img_name = tmp_img_url[len(tmp_img_url) - 1]
        img = folder + '/' + img_name
        if os.path.exists(img):
            os.remove(img)
        with open(img, 'wb') as f:
            f.write(cat_img)
            # f.close()
        return img

    def getCarBrand(self):
        print "Spider start"
        post_url_list = self.setPostString()
        for initials in post_url_list:
            print
            initials
            url = self.siteURL + initials + "_photo.html"
            self.curr_post_url = url
            self.initials = initials
            post_html_data = self.postData(url)
            tmp = self.getData(post_html_data)
            self.brand_list.append(tmp)
        # print self.brand_list
        print
        "Spider end"
        self.inserDataBase(self.brand_list)

    def inserDataBase(self, brand_list):
        # ims_autoparts_car_brand
        # ims_autoparts_car_type
        print
        "Start insert"
        conn = pymysql.connect(host='127.0.0.1', port=3306, user='root', passwd='admin123', db='auto_mall',
                               charset='utf8')
        cursor = conn.cursor()

        for items in brand_list:
            # print items

            for item in items:
                name = item["name"].decode("gbk")
                print
                name
                brand = ("4", "0", item["initials"], name, item["pic_url"], "1", "1", "0", "1527063241")
                print
                "Inserting brand data"
                effect_row = cursor.executemany(
                    "insert into ims_autoparts_car_brand(uniacid,parent_id,initials,name,pic_url,status,sort,is_hot,create_time)values(%s,%s,%s,%s,%s,%s,%s,%s,%s)",
                    [brand])
                pid = cursor.lastrowid
                for ite in item["types"]:
                    print
                    "Inserting car type data"
                    name = ite["name"].encode('unicode_escape').decode('string_escape').decode("gbk")
                    # print name
                    # exit()
                    type = ("4", pid, name, ite["pic_url"], "1", "1", "1527063241")
                    effect_row = cursor.executemany(
                        "insert into ims_autoparts_car_type(uniacid,brand_id,name,pic_url,status,sort,create_time)values(%s,%s,%s,%s,%s,%s,%s)",
                        [type])
                # conn.commit()
                # print pid
        cursor.close()
        conn.close()
        print
        "Program finish!"
        exit;


spider = CatSpider()
spider.getCarBrand()
