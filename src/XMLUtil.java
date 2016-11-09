import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class XMLUtil {
	public static Object getBean(int i){
		try {
			//�������ڶ���
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("config.xml"));
			
			//��ȡ����ͼ�����͵��ı��ڵ�
			Node classNode = null;
			String cName = null;
			NodeList nl = doc.getElementsByTagName("className");//��ȡtagΪclassName��item
			
			if(i == 0){
				classNode = nl.item(0).getFirstChild();//����ά��ͼ������
			}else{
				classNode = nl.item(1).getFirstChild();//
			}
			
			//ʵ��Ŀ�����
			cName = classNode.getNodeValue().trim();
			Class c = Class.forName(cName);
			Object obj = c.newInstance();
			return obj;
		} catch (ParserConfigurationException | SAXException | IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
