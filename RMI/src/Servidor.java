import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class Servidor implements Metodos{

	
	
	public static void main(String[] args) {
		
		
		try {
			
			Servidor obj = new Servidor();			
			Metodos stub = (Metodos) UnicastRemoteObject.exportObject(obj, 3030);		
			Registry registry = LocateRegistry.createRegistry(3030);
			registry.bind("Metodos", stub);
			System.out.println("Servidor rodando!");			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String hora() throws RemoteException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
		
		return dateFormat.format( new Date());
	}
	
	@Override
	public String fraseMotivacional() throws RemoteException {
		List<String> frases = new ArrayList<>();
		Random r = new Random();
		
		frases.add("Viver nao e esperar a tempestade passar, e dancar na chuva");
		frases.add("Humildade nao te faz melhor que ningu�m, mas te faz diferente de muitos.");
		frases.add("Quando o caminho se torna duro, s� os duros continuam caminhando.");
		frases.add("N�o corrigir nossas falhas � o mesmo que cometer novos erros.");
		frases.add("A melhor maneira que o homem disp�e para se aperfei�oar, � aproximar-se de Deus.");
		
		String frase = frases.get(r.nextInt(4));
		return frase;
	}

	@Override
	public int multiplicacao() throws RemoteException {
		
		int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o 1� para multiplica��o"));
		int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o 2� para multiplica��o"));
		int c = a*b;
		
		return c;
	}

	@Override
	public int soma() throws RemoteException {
		int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o 1� para soma"));
		int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o 2� para soma"));
		int c = a+b;
		
		return c;
	}
	
	@Override
	public String sayHello() throws RemoteException {
		
		return "Hello World";
	}

	

	

}
