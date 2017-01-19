import com.sun.org.apache.xerces.internal.util.SymbolTable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.management.Notification;

/**
 * The SymTable class must be in a file named SymTable.java.
 * It must be implemented using a List of HashMaps.
 * (Think about the operations that will be done on a SymTable to decide whether to use
 * an ArrayList or a LinkedList.) The HashMaps must map a String to a Sym.
 * This means that the SymTable class will have a (private) field of type
 * List<HashMap<String,Sym>>.
 *
 * Created by junjie on 1/19/17.
 */
public class SymTable {

    /**
     *  	This is the constructor;
     *  	it should initialize the SymTable's List field to contain a single, empty HashMap.
     */
    public SymTable(){

    }


    /**
     * If this SymTable's list is empty, throw an EmptySymTableException.
     * If either name or sym (or both) is null, throw a NullPointerException.
     * If the first HashMap in the list already contains the given name as a key, throw a DuplicateSymException.
     * Otherwise, add the given name and sym to the first HashMap in the list.
     * @param name
     * @param sym
     * @throws DuplicateSymException
     * @throws EmptySymTableException
     */
    public void addDecl(String name, Sym sym) throws DuplicateSymException, EmptySymTableException{


    }

    /**
     * Add a new, empty HashMap to the front of the list.
     */
    public void addScope(){

    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException.
     * Otherwise, if the first HashMap in the list contains name as a key, return the associated Sym; otherwise, return null
     * @param name
     * @return
     */
    public Sym lookupLocal(String name){
        throw new NotImplementedException();
    }


    /**
     * If this SymTable's list is empty, throw an EmptySymTableException.
     * If any HashMap in the list contains name as a key, return the first associated Sym
     * (i.e., the one from the HashMap that is closest to the front of the list); otherwise, return null.
     * @param name
     * @return
     */
    public Sym lookupGlobal(String name){
        throw new NotImplementedException();
    }


    /**
     * If this SymTable's list is empty, throw an EmptySymTableException;
     * otherwise, remove the HashMap from the front of the list.
     * To clarify, throw an exception only if before attempting to remove, the list is empty (i.e. there are no HashMaps to remove).
     * @throws EmptySymTableException
     */
    public void removeScope() throws EmptySymTableException{
        throw new NotImplementedException();
    }

    /**
     * This method is for debugging. First, print “\nSym Table\n”. Then, for each HashMap M in the list,
     * print M.toString() followed by a newline. Finally, print one more newline. All output should go to System.out.
     */
    public void print(){

    }
}
