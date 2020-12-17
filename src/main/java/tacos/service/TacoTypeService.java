package tacos.service;

import org.springframework.data.domain.Page;
import tacos.domain.TacoType;
import tacos.domain.User;

public interface TacoTypeService {

    TacoType saveTacoType(TacoType tacoType);

    TacoType getTacoType(long tacoId);

    Page<TacoType> getTacoTypesByUser(User user, int pageNum);
}
