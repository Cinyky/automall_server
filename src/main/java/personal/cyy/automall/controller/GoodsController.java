package personal.cyy.automall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;
import personal.cyy.automall.common.CommonResult;
import personal.cyy.automall.constant.TemplateNameConstant;
import personal.cyy.automall.model.Car;
import personal.cyy.automall.model.CarImage;
import personal.cyy.automall.service.FileServiceImpl;
import personal.cyy.automall.service.GoodsServiceImpl;
import personal.cyy.automall.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 商品模块
 *
 * @Author Cinyky
 * @Date 11:53 2019-05-15
 */

@Controller
public class GoodsController extends IController {

    @Autowired
    GoodsServiceImpl goodsService;

    @Autowired
    FileServiceImpl fileService;

    /**
     * get 进入添加商品页面
     *
     * @param model
     * @return
     */
    @GetMapping("/goods/goods_add")
    public String template(Model model) {
        model.addAttribute("car", new Car());
        return "goods/goods_add";
    }

    /**
     * 增加商品
     *
     * @param car
     * @param files
     * @param model
     * @return
     */
    @PostMapping("/goods/goods_add")
    @ResponseBody
    public String goodsAdd(@ModelAttribute Car car, @RequestParam(value = "images") MultipartFile[] files, Model model
    ) {
//        car - {"band":"123123","checkTime":"17-05-2019","createTime":0,"description":0,"distance":100000,"insuranceTime":"10-05-2019",
//        "mark":"123","model":0,"outputVolume":3,"price":"2","regTime":"06-05-2019","status":0,"title":123,"transferNum":1,"updateTime":0} configs Alabama, 213, 232
        car.setId(CommonUtils.getGUID());
        List<CarImage> images = new ArrayList<>();
        for (MultipartFile file : files) {
            CommonResult commonResult = fileService.saveFormFile(file);
            String imageId = (String) commonResult.getData();
            if (StringUtils.isEmpty(imageId)) {
                continue;
            }
            CarImage carImage = new CarImage();
            carImage.setId(CommonUtils.getGUID());
            carImage.setCarId(car.getId());
            carImage.setImageId(imageId);
            images.add(carImage);
        }
        car.setCarImages(images);
        car.setCreateTime(System.currentTimeMillis());
        car.setUpdateTime(System.currentTimeMillis());
        CommonResult commonResult = goodsService.addNewCar(car);
        model.addAttribute("jsonResult", commonResult);
        return TemplateNameConstant.RESULT;
    }

    /**
     * 商品列表
     * @param model
     * @return
     */
    @RequestMapping("/goods/goods_list")
    public String goodsList(Model model) {
        Collection<Car> cars = goodsService.getAllGoods();
        model.addAttribute("cars", cars);
        return "goods/goods_list";
    }

    @RequestMapping("/goods/delete/{carId}")
    @ResponseBody
    public CommonResult delete(@PathVariable String carId) {
        goodsService.deleteGoods(carId);
        return CommonResult.success(carId);
    }

    /**
     * 获取制定ID 的商品
     * @param carId
     * @param model
     * @return
     */
    @RequestMapping("/goods/goods_detail/{carId}")
    public String goodsDetail(@PathVariable String carId, Model model) {
        Car car = goodsService.getGoodsById(carId);
        model.addAttribute("car", car);
        return "goods/goods_list";
    }



}
