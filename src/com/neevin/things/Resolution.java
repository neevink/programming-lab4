package com.neevin.things;

import com.neevin.exceptions.ExceptionHelper;
import com.neevin.characters.BookCharacter;
import com.neevin.interfaces.IDocument;
import com.neevin.misc.Signature;

import java.util.ArrayList;

// Бумажный документ, который можно подписать
public class Resolution implements IDocument {
    public final String name;
    protected String innerText;
    ArrayList<Signature> signers = new ArrayList<Signature>();

    public Resolution(String name,String text) {
        if(name == null){
            ExceptionHelper.nullArgument("name");
        }
        if(text == null){
            ExceptionHelper.nullArgument("text");
        }

        this.innerText = text;
        this.name = name;
    }

    @Override
    public String getInnerText(){
        return innerText;
    }

    @Override
    public void sign(Signature signature) {
        if(signature == null){
            ExceptionHelper.nullArgument("signature");
        }

        signers.add(signature);
        System.out.println(signature.getOwner().name + " подписал " + this.name);
    }

    // Подписан ли документ персонажем
    @Override
    public boolean signedBy(BookCharacter character) {
        if(character == null){
            ExceptionHelper.nullArgument("character");
        }

        for(Signature s : signers){
            if(s.getOwner().equals(character)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return ("резолюция \"" + name +"\"");
    }

    @Override
    public int hashCode() {
        return innerText.hashCode() + name.hashCode();
    }

    @Override
    public boolean equals(Object otherObject) {
        if(otherObject == this){
            return true;
        }

        if(otherObject == null){
            return false;
        }

        if(otherObject instanceof Resolution){
            Resolution other = (Resolution)otherObject;
            return name.equals(other.name) && innerText.equals(other.innerText);
        }
        return false;
    }
}
