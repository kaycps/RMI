import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
	
	public static void main(String[] args) {	
		
		
		try {
			
			Registry registry = LocateRegistry.getRegistry(3030);
			Metodos stub = (Metodos) registry.lookup("Metodos");
			String response = stub.hora();
			System.out.println("response: "+response);			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
