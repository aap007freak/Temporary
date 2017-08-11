package com.antonleagre.temporary.states;

import com.antonleagre.temporary.Main;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GSM {
    private Stack<State> states;
    private Main game;


    public GSM(Main game){
        this.game = game;
        states = new Stack<State>();

    }

    public void update(float dt){
        states.peek().update(dt);
    }
    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
    public void dispose(){
        for(State s : states){
            s.dispose();
        }
    }

    public void pushState(State s){
        states.push(s);
    }
    public void setState(State s){
        states.pop().dispose();
        states.push(s);
    }
    public void popState(){
        states.pop();
    }

    public Main getGame() {
        return game;
    }

}
