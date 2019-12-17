package personal.cyy.automall.contract;

/**
 * @author yuyunchen
 * @date 2019/12/17 16:09
 * @email cyy1079276272@163.com
 */
public class UploadResponse {

    private String imageId;
    private String downloadURL;
    private String url;


    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
