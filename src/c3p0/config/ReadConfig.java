package c3p0.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * 读取配置文件
 * @author Administrator
 *
 */
public class ReadConfig {

	/** 单例 */
	private static ReadConfig read=null;
	/** 配置文件集合 */
	private static Map<String,configEntity> map=new HashMap<String,configEntity>();
	/**
	 * 读取配置
	 */
	private ReadConfig(){
		SAXBuilder sax=new SAXBuilder();
		Document doc=null;
		try {
			doc=sax.build(this.getClass().getClassLoader().getResourceAsStream("c3p0-config.xml"));
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element doce=doc.getRootElement();
		List<Element> DateNamelist = doce.getChildren();
		System.out.println("名字集合"+DateNamelist.size());
		for(Element datename:DateNamelist){
			String DataName=datename.getAttributeValue("name");
			List<Element> propertyList = datename.getChildren();
			System.out.println("所有子节点的集合"+propertyList.size());
			configEntity entity=new configEntity();
			for(Element proper:propertyList){
				String name=proper.getAttributeValue("name");
				String value=proper.getText();
				entity.SetAttributer(entity, name, value);
			}
			System.out.println(entity.getDriverClass()+":"+entity.getJdbcUrl()+":"+entity.getUser()+":"+entity.getInitialPoolSize()+":"+entity.getMaxIdleTime()+":"+entity.getPassword()+":"+entity.getMaxPoolSize());
			map.put(DataName, entity);
		}
		System.out.println(map.size());
	}
	/**
	 * 获取readConfig对象
	 * @return
	 */
	public static ReadConfig getReadConfig(){
		if(read==null){
			read=new ReadConfig();
		}
		return read;
	}
	/**
	 * 获取配置集合
	 * @return
	 */
	public static Map<String,configEntity> getConfigMap(){
		return map;
	}
}
