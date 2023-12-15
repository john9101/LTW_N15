package dao;

import models.ID;
import models.Size;

import java.util.List;

public interface SizeDAO {
    List<Size> getAllSize();

    List<ID> getIdProduct(String size);
}
