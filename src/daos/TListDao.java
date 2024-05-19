package daos;

import models.TList;

import java.util.List;
import java.util.UUID;

public interface TListDao {
    UUID insertTList(TList tList);
    TList getTList(UUID id);
    List<TList> getAllTLists();
    void updateTList(TList tList);
    void deleteTList(UUID id);
}
