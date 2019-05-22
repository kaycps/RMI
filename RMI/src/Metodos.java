import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Metodos  extends Remote{
	
	String sayHello() throws RemoteException;
	String hora() throws RemoteException;
	String fraseMotivacional() throws RemoteException;
	int multiplicacao()throws RemoteException;
	int soma()throws RemoteException;
	
		
	
	
}
