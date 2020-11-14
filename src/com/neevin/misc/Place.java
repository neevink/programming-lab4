package com.neevin.misc;

import com.neevin.characters.BookCharacter;

import java.util.ArrayList;

public class Place{
    protected String name;
    protected ArrayList<BookCharacter> characters = new ArrayList<BookCharacter>();

    public Place(String name){
        this.name = name;
    }

    //Описать сцену
    public void describe(){
        if(characters.isEmpty()){
            System.out.println("На местности \"" + name + "\" никого нет.");
        }

        String output = "На местности \"" + name + "\" собрались";
        var names = peek();
        for (var e : names){
            output += " \"" + e + "\"";
        }
        System.out.println(output);
    }

    //Получить список имён персонажей на сцене
    public ArrayList<String> peek(){
        var names = new ArrayList<String>();
        for(var e : characters){
            names.add(e.toString());
        }
        return names;
    }

    //Есть ли персонаж с именем в этом месте?
    public boolean contains(String characterName){
        for(var e : characters){
            if(e.toString() == characterName){
                return true;
            }
        }
        return false;
    }

    //Получить персонажа места
    public BookCharacter getCharacter(String characterName){
        for(var e : characters){
            if(e.toString() == characterName){
                return e;
            }
        }

        throw new IllegalArgumentException("Персонажа нет на локации.");
    }

    public void addCharacters(BookCharacter... chs){
        for(var e : chs){
            characters.add(e);
        }
    }

    public void removeCharacter(String characterName){
        if(!contains(characterName)){
            throw new IllegalArgumentException("Персонажа нет на локации.");
        }

        for(var e : characters){
            if(e.toString() == characterName){
                characters.remove(e);
                return;
            }
        }
    }

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public int hashCode(){
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Place){
            var character = (Place)other;

            if(name == character.name){
                return true;
            }
        }
        return false;
    }
}