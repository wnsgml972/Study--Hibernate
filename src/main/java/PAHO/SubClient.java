package PAHO;
import java.awt.Font;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubClient {
	
    //private String topic = "/topic/sample";    
    private MqttClient client;
    
    public SubClient(){
		subscribe("topic");
    }
    
	public void subscribe(String topic) {
        
		try {
			client = new MqttClient("localhost", MqttClient.generateClientId(), new MemoryPersistence());		
			// init
			
			client.connect();
			// connect			
			
			client.setCallback(new MqttCallback() {
				public void messageArrived(String topic, MqttMessage message) throws Exception {
					System.out.println(topic);
					System.out.println(message.toString() + "\n");
				
				}
				public void deliveryComplete(IMqttDeliveryToken arg0) {
					// TODO Auto-generated method stub
				}
				public void connectionLost(Throwable arg0) {
					// TODO Auto-generated method stub
				}
			});
			// set callback
			
			client.subscribe(topic, 1);
			// subscribe
			
		}  catch(MqttException me) {

        }
	}
	
	public void clientDisConnect(){
		try {
			client.disconnect();
			client.close();
		} catch (MqttException e) {

		}
	}
	
	public static void main(String[] args) {
		new SubClient();

	}
	
}