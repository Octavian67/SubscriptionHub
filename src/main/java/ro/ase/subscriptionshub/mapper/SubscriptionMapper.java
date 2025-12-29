package ro.ase.subscriptionshub.mapper;

import org.springframework.stereotype.Component;
import ro.ase.subscriptionshub.data.entity.SubscriptionEntity;
import ro.ase.subscriptionshub.data.models.Subscription;
import ro.ase.subscriptionshub.data.models.SubscriptionType;
import ro.ase.subscriptionshub.data.models.SubscriptionViewModel;
import ro.ase.subscriptionshub.data.models.VideoQuality;

@Component
public class SubscriptionMapper {

    public static SubscriptionEntity toEntity(Subscription source) {
        if (source == null) return null;

        SubscriptionEntity entity = new SubscriptionEntity();
        entity.setType(source.getType() != null ? source.getType().name() : null);
        entity.setName(source.getName());
        entity.setDescription(source.getDescription());
        entity.setVideoQuality(source.getVideoQuality() != null ? source.getVideoQuality().name() : null);
        entity.setMaxUsers(source.getMaxUsers());
        entity.setOffline(source.canDownloadOffline());

        return entity;
    }

    public static SubscriptionViewModel toViewModel(SubscriptionEntity entity) {
        if (entity == null) return null;

        SubscriptionViewModel vm = new SubscriptionViewModel();

        vm.setType(entity.getType() != null ? SubscriptionType.valueOf(entity.getType()) : null);
        vm.setVideoQuality(entity.getVideoQuality() != null ? VideoQuality.valueOf(entity.getVideoQuality()) : null);

        vm.setName(entity.getName());
        vm.setDescription(entity.getDescription());
        vm.setMaxUsers(entity.getMaxUsers());
        vm.setOffline(entity.isOffline());

        return vm;
    }
}
