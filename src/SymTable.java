///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            CS 536 Assignment 1
// Files:            SymTable.java
// Semester:         Spring 2017
//
// Author:           Junjie Xu
// Email:            jxu259
// CS Login:         junjie
// Lecturer's Name:  Thomas Reps
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////


import java.util.*;

/**
 * The SymTable class must be in a file named SymTable.java.
 * It must be implemented using a List of HashMaps.
 * (Think about the operations that will be done on a SymTable to decide whether
 * to use an ArrayList or a LinkedList.) The HashMaps must map a String to a Sym
 * This means that the SymTable class will have a (private) field of type
 * List<HashMap<String,Sym>>.
 *
 * Created by junjie on 1/19/17.
 */
public class SymTable {

    private LinkedList<HashMap<String, Sym>> table;

    /**
     *  	This is the constructor;
     *  	it should initialize the SymTable's List field to contain a single,
     *  	empty HashMap.
     */
    public SymTable(){
        table = new LinkedList<HashMap<String, Sym>>();
        table.push(new HashMap<String, Sym>());

    }


    /**
     * If this SymTable's list is empty, throw an EmptySymTableException.
     * If either name or sym (or both) is null, throw a NullPointerException.
     * If the first HashMap in the list already contains the given name as a key
     * , throw a DuplicateSymException.
     * Otherwise, add the given name and sym to the first HashMap in the list.
     * @param name: symbol name
     * @param sym: the Sym instance associated with this symbol name
     * @throws DuplicateSymException when there is the given name as a key
     * @throws EmptySymTableException when there is no HashMap also called
     *                                  Scope in the list
     */
    public void addDecl(String name, Sym sym) throws DuplicateSymException,
            EmptySymTableException{
        if (name == null || sym == null) {
            throw new NullPointerException("Null argument for method addDecl.");
        }

        if (this.table.size() == 0){
            throw new EmptySymTableException();
        }

        // get the lowest scope, also called currentScope
        HashMap<String,Sym> currentScope = this.table.peek();

        if (currentScope.containsKey(name)){
            throw new DuplicateSymException();
        }

        // One question is whether it's possible that the sym also gets key by
        // others

        currentScope.put(name, sym);
    }

    /**
     * Add a new, empty HashMap to the front of the list.
     */
    public void addScope(){
        this.table.push(new HashMap<String, Sym>());
    }


    /**
     * If this SymTable's list is empty, throw an EmptySymTableException.
     * Otherwise, if the first HashMap in the list contains name as a key,
     * return the associated Sym;
     * otherwise, return null
     * @param name: the name you want to look up
     * @return: the symbol information associated with
     *          this name in the lowest scope otherwise return null
     */
    public Sym lookupLocal(String name) throws EmptySymTableException {
        if (name == null){
            throw new NullPointerException();
        }

        checkTableWhetherEmpty();
        return lookupInOneScope(this.table.peek(), name);
    }

    /**
     * This method checks whether the table is empty.
     * @throws EmptySymTableException
     */
    private void checkTableWhetherEmpty() throws EmptySymTableException{
        if (this.table.size() == 0){
            throw new EmptySymTableException();
        }
    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException.
     * If any HashMap in the list contains name as a key, return the first
     * associated Sym (i.e., the one from the HashMap that is closest to the
     * front of the list); otherwise, return null.
     * @param name: the name of the symbol you want to look up
     * @return
     */
    public Sym lookupGlobal(String name) throws EmptySymTableException{
        if (name == null){
            throw new NullPointerException();
        }

        checkTableWhetherEmpty();

        // Search each scope until one non-null result has been found;
        for (HashMap<String, Sym> scope: this.table){
            Sym result = lookupInOneScope(scope, name);
            if (result != null){
                return result;
            }
        }

        return null;
    }

    /**
     * find the sym based on the given name.
     * @param scope the place for searching
     * @param name sym key
     * @return The sym object for the scope. Null if can't find the key
     */
    private Sym lookupInOneScope(HashMap<String, Sym> scope, String name){
        return scope.getOrDefault(name,null);
    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException;
     * otherwise, remove the HashMap from the front of the list.
     * To clarify, throw an exception only if before attempting to remove,
     * the list is empty (i.e. there are no HashMaps to remove).
     * @throws EmptySymTableException
     */
    public void removeScope() throws EmptySymTableException{
        try{
            this.table.pop();
        } catch (NoSuchElementException e){
            throw new EmptySymTableException();
        }
    }

    /**
     * This method is for debugging. First, print “\nSym Table\n”. Then, for
     * each HashMap M in the list, print M.toString() followed by a newline.
     * Finally, print one more newline. All output should go to System.out.
     * Example Output:
     * SymTable
     * {}
     * {a=ASS}
     * {}
     * {}
     */
    public void print(){
        System.out.print("\nSym Table\n");

        for (HashMap<String, Sym> scope: this.table){
            System.out.println(scope.toString());
        }

        System.out.println();
    }
}
