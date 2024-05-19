package daos;

import data.Db;
import exceptions.TListNotFoundException;
import models.TList;

import java.util.List;
import java.util.UUID;

public class TDaoListImpl implements TListDao{
    private final Db db = Db.getInstance();

    @Override
    public UUID insertTList(TList tList) {
        db.tLists.put(tList.getId(), tList);
        return tList.getId();
    }

    @Override
    public TList getTList(UUID id) {
        TList tList = db.tLists.get(id);
        if (tList == null) throw new TListNotFoundException();
        return tList;
    }

    @Override
    public List<TList> getAllTLists() {
        return (List<TList>) db.tLists.values();
    }

    @Override
    public void updateTList(TList newTList) {
        TList oldTList = db.tLists.get(newTList.getId());
        if (oldTList == null) throw new TListNotFoundException();
        db.tLists.put(newTList.getId(), newTList);
    }

    @Override
    public void deleteTList(UUID id) {
        TList tList = db.tLists.get(id);
        if (tList == null) throw new TListNotFoundException();
        db.tLists.remove(id);
    }
}
