package comm.special;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * 描述: 获取网页信息 .<br>
 * @author lilihao
 * @date 2016年7月5日
 */
public class HttpURL {

	/**
	 * 描述: 根据url获取网页信息 .
	 * @author lilihao
	 * @date 2016年7月5日
	 * @param ssourl
	 * @return
	 */
	public static String getHtmlConentByUrl(String ssourl) {
		try {
			URL url = new URL(ssourl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setInstanceFollowRedirects(false);
			con.setUseCaches(false);
			con.setAllowUserInteraction(false);
			con.connect();
			StringBuffer sb = new StringBuffer();
			String line = "";
			BufferedReader URLinput = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));

			while ((line = URLinput.readLine()) != null) {
				sb.append(line);
			}

			con.disconnect();
			return sb.toString().toLowerCase();

		} catch (Exception e) {

			return null;
		}
	}
}
