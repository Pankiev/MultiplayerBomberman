package pl.gda.pg.student.project.server.objects;

import java.util.Collections;
import java.util.List;

import pl.gda.pg.student.project.libgdxcommon.State;
import pl.gda.pg.student.project.libgdxcommon.objects.MovableGameObject;
import pl.gda.pg.student.project.server.GameServer;

public class ServerPlayer extends MovableGameObject
{
    private int maximumNumberOfPlacedBombs;
    private int numberOfPlacedBombs;
    private List<Long> bombsId = Collections.emptyList();
    private int rangeOfExplosion;

    public ServerPlayer(State linkedState)
    {
        super(GameServer.assets.get("pacman_dol.png"), linkedState);
        maximumNumberOfPlacedBombs = 1;
        numberOfPlacedBombs = 0;
        rangeOfExplosion = 1;
    }

    public boolean tryPlaceBomb(){
        if(numberOfPlacedBombs < maximumNumberOfPlacedBombs) {
            numberOfPlacedBombs++;
            return true;
        }
        return false;
    }

    public void placeBomb(long id){
        bombsId.add(id);
    }

    public void removeBomb(long id){
        bombsId.remove(id);
    }

    public void increaseRange(){
        rangeOfExplosion++;
    }

    @Override
    public void update()
    {

    }

    @Override
    public String getIdentifier() {
        return ObjectsIdentifier.getObjectIdentifier(ServerPlayer.class);
    }

}
