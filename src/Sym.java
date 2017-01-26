import sun.reflect.generics.reflectiveObjects.NotImplementedException;


/**
 *
 * Created by junjie on 1/19/17.
 */


public class Sym {

    private String type;

    public Sym(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public String toString(){
        return type;
    }
}
