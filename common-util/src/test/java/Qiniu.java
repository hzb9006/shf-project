import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.junit.jupiter.api.Test;

public class Qiniu {
    /**
     * 测试向七牛云上传文件
     */
    @Test
    public void testUpload(){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
//...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        // 去个人中心密钥管理中将AK和SK拷贝过来
        String accessKey = "rF7HlwNrzdnnZtC65xFqvgNP5eW-9EYiQ_KCwk8K";
        String secretKey = "ARpoADBLwvP0_ZFjKqjQOlaILBznCTpZS2M0Y_nC";
        // 设置空间名字
        String bucket = "shfcode1";
//如果是Windows情况下，格式是 D:\\qiniu\\test.png
        // 设置本地路径
        String localFilePath = "C:\\Users\\大饼干\\Desktop\\身份证\\skystar2.jpg";
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }

    }
}
