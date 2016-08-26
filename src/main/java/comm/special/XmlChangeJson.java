package comm.special;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


import com.thoughtworks.xstream.XStream;

/**
 * 描述: XML转换JSON通用方法 .<br>
 * @author lilihao
 * @date 2016年7月5日
 */
public class XmlChangeJson<T>{

	private XStream xs = new XStream();
	/**
	 * 描述: 根据 xml转换java对象.
	 * @author lilihao
	 * @date 2016年7月5日
	 * @return
	 * @throws FileNotFoundException
	 */
	public T convertBean(String url) throws FileNotFoundException {
		T remot = (T)xs.fromXML(new FileInputStream(new File(url)));
		return remot;
	}

	/**
	 * 描述:根据java对象转换XML .
	 * @author lilihao
	 * @date 2016年7月5日
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	public String convertXml(T t) throws FileNotFoundException, UnsupportedEncodingException{
		xs.autodetectAnnotations(true);
		String xml = xs.toXML(t);
		return xml;
	}

}