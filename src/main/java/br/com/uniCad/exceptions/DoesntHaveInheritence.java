package br.com.uniCad.exceptions;

/**
 * Created by Pedro Queiroz on 09/11/2016.
 */
public class DoesntHaveInheritence extends Exception
{
    public DoesntHaveInheritence(){
        super();
    }

    public DoesntHaveInheritence(String message){
        super(message);
    }
}
