package dados;

import negocio.entidades.Cliente;

import java.io.*;
import java.util.ArrayList;

public class RepositorioClientes implements IRepositorioClientes, Serializable {

    @Serial
    private static final long serialVersionUID = -4009776605163947716L;
    private ArrayList<Cliente> clientes;
    private File file;

    public RepositorioClientes() {
        file = new File("clientes.dat");
        if (file.exists()) {
            lerClientes();
        } else {
            clientes = new ArrayList<Cliente>();
            escritaClientes();
        }
    }


    public void lerClientes() {
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            clientes = (ArrayList<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            clientes = new ArrayList<Cliente>();
        }
    }


    public void escritaClientes() {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutput oos = new ObjectOutputStream(fos);
            oos.writeObject(clientes);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            clientes = new ArrayList<Cliente>();
        }
    }

    @Override
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        escritaClientes();
        lerClientes();
    }

    @Override
    public boolean validarCliente(String login, String senha) {
        lerClientes();
        boolean clienteEncontrado = false;
        for(Cliente u : clientes){
            if(u.getLogin().equals(login) && u.getSenha().equals(senha)){
                clienteEncontrado = true;
                return clienteEncontrado;
            }
        }
        return clienteEncontrado;
    }

    @Override
    public Cliente retornarCliente(String login, String senha) {
        for (Cliente c : clientes) {
            if (c.getLogin().equals(login) && c.getSenha().equals(senha)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    @Override
    public void imprimir() {
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    @Override
    public boolean existe(String login) {
        for (Cliente cliente : clientes) {
            if (cliente.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
}
