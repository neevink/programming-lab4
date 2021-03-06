package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.interfaces.ISignatureMaker;
import com.neevin.misc.Phrase;
import com.neevin.misc.Signature;

public class Owl extends BookCharacter{

    public Owl(String name, CharacterType type, ISignatureMaker signature){
        super(name, type, signature);
    }

    public void fly(){
        System.out.println(this.name + " полетел");
    }
}
