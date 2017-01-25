
/**
 * This main method is used to test the implementation of the Sym and SymTable
 *
 * Created by junjie on 1/19/17.
 */
public class P1 {

    public static void main(String[] args){

        // Create Symbol table
        SymTable symbolTable =  new SymTable();

        // Create bunch of syms
        Sym spidermanSym = new Sym("SuperHero");
        Sym batmanSym = new Sym("SuperHero");
        Sym jokerSym = new Sym("Villain");

        // Test symbol print
        if (! spidermanSym.toString().equals("SuperHero")){
            System.out.println("Wrong result for sym toString()");
        }

        // Test symbol getType
        if (! spidermanSym.getType().equals("SuperHero")){
            System.out.println("Wrong result for sym getType()");
        }

        // delete the scope
        // add the symbol to the first scope
        try{
            symbolTable.addDecl("spiderman", spidermanSym);
        } catch (DuplicateSymException e){

        } catch (EmptySymTableException e){
            System.out.print(String.format("There should be one empty scope after initializaion"));
        }

        // remove that scope
        try{
            symbolTable.removeScope();
        } catch (EmptySymTableException e){
            System.out.println("There should be one empty scope after initializaion");
        }

        //Test empty sym table
        try{
            symbolTable.removeScope();
            System.out.println("No exception thrown on attempt to remove scope");
        } catch (EmptySymTableException e){

        }

        try{
            symbolTable.addDecl("spiderman", spidermanSym);
            System.out.println("No exception thrown on attempt to add symbol");

        }catch (DuplicateSymException e){

        }catch (EmptySymTableException e){
        }


        symbolTable.addScope();

        // Test add scope works well
        try{
            symbolTable.removeScope();
        } catch (EmptySymTableException e ){
        }

        try{
            symbolTable.removeScope();
            System.out.println("Add scope does not work right");
        }catch (EmptySymTableException e){
        }


        // Test null pointer
        try{
            symbolTable.addDecl(null, jokerSym);
            System.out.println("No exception thrown on attempt to add null");
        } catch (DuplicateSymException e){

        } catch (EmptySymTableException e){

        } catch (NullPointerException e){
        }

        try{
            symbolTable.addDecl("joker", null);
            System.out.println("No exception thrown on attempt to add null");
        } catch (DuplicateSymException e){

        } catch (EmptySymTableException e){

        } catch (NullPointerException e){
        }

        // add three sym
        try {
            symbolTable.addDecl("spiderman", spidermanSym);
            symbolTable.addDecl("batman", batmanSym);
            symbolTable.addDecl("joker", jokerSym);
            symbolTable.addDecl("batman", batmanSym);
            System.out.println("No exception for adding the duplicate");
        } catch (DuplicateSymException e){

        } catch (EmptySymTableException e){
        }


        // Now we have four scopes, one with three symbol
        for (int i=0; i< 3; i++){
            symbolTable.addScope();
        }

        // Test lookup local with null
        if(symbolTable.lookupLocal("DoctorWho?")!= null){
            System.out.println("Wrong result for looking something that doesn't exist in local.");
        }

        if(symbolTable.lookupGlobal("DoctorWho?")!= null){
            System.out.println("Wrong result for looking something that doesn't exist in global.");
        }

        Sym batmanDupSym = new Sym("Hero");
        try {
            // now we can try to look bat up
            symbolTable.addDecl("batman", batmanDupSym);
        } catch (DuplicateSymException e){

        } catch (EmptySymTableException e){

        }

        // Test lookup the local
        if (symbolTable.lookupLocal("batman") != batmanDupSym ){
            System.out.println("This is wrong result for lookupLocal");
        }

        // Test lookup the batman
        if (symbolTable.lookupGlobal("batman") != batmanDupSym){
            System.out.println("This is wrong result for lookup Global");
        }

        symbolTable.addScope();
        if (symbolTable.lookupGlobal("batman") == batmanSym){
            System.out.println("Lookup global doesn't follow the rule of only finding the closest scope");
        }

        if (symbolTable.lookupLocal("batman")!= batmanSym){
            System.out.println("Wrong result for looking up Global");
        }

    }
}
