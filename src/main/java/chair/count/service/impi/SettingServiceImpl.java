package chair.count.service.impi;

import chair.count.dao.SettingDao;
import chair.count.dto.GameSettingsRequest;
import chair.count.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SettingServiceImpl implements SettingService {

    @Autowired
    private SettingDao settingDao;

    @Override
    public Integer createSetting(GameSettingsRequest gameSettingsRequest) {
        return settingDao.createSetting(gameSettingsRequest);
    }
}