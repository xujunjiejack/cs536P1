///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            CS 536 Assignment 1
// Files:            Sym.java
// Semester:         Spring 2017
//
//
// Author:           Junjie Xu
// Email:            jxu259
// CS Login:         junjie
// Lecturer's Name:  Thomas Reps
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////

/**
 * Object representation for the Sym. One Sym is associated with one type.
 * The type is inmutable
 *
 * Created by junjie on 1/19/17.
 */


public class Sym {

    // The type assoicated this symbol
    private String type;

    /**
     * The default constructor for constructing the sym.
     * @param type
     */
    public Sym(String type){
        this.type = type;
    }

    /**
     * Return the type associated with this symbol
     * @return
     */
    public String getType(){
        return type;
    }

    /**
     * Return the type associated with this symbol
     * @return
     */
    public String toString(){
        return type;
    }
}
