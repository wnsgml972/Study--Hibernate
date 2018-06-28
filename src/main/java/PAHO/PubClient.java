package PAHO;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PubClient {
	//private String topic = "/topic/sample";
	//private String content = "Message from MqttPublishSample";
	private int qos = 0;
	
	public PubClient() {
		System.out.println("실행");
		publish("a/b/c/d", "하이하이");
	}
	
	public void publish(String topic, String content){
		
		try {
			MqttClient client = new MqttClient("tcp://223.194.128.249:1883", MqttClient.generateClientId(), new MemoryPersistence());
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			// init

			
			client.connect(connOpts);
			// connect

			
			MqttMessage message = new MqttMessage(content.getBytes());
			//set message
			
			
			message.setQos(qos);
			// set qos

			client.publish(topic, message);

			// publish
			
			
			client.disconnect();
			// disconnect			

			
		} catch (MqttException me) {
			
		}
	}
	
	public static void main(String[] args) {
		new PubClient();
	}
}