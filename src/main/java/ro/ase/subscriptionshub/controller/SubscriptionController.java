package ro.ase.subscriptionshub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.ase.subscriptionshub.data.models.*;
import ro.ase.subscriptionshub.service.SubscriptionService;
import ro.ase.subscriptionshub.utils.SubscriptionUtils;

import java.util.Set;

@Controller
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    private final SubscriptionUtils subscriptionUtils;

    public SubscriptionController(SubscriptionService subscriptionService, SubscriptionUtils subscriptionUtils) {
        this.subscriptionService = subscriptionService;
        this.subscriptionUtils = subscriptionUtils;
    }

    @GetMapping("/")
    public String home(Model model) {

        SubscriptionViewModel currentSubscription = subscriptionService.getSubscription();

        model.addAttribute("currentSubscription", currentSubscription);
        return "index";
    }

    @GetMapping("/subscriptions")
    public String showSubscriptions(Model model) {
        model.addAttribute("subscriptionTypes", SubscriptionType.values());
        return "subscriptions";
    }

    @GetMapping("/subscriptions/configure")
    public String configureSubscription(
            @RequestParam SubscriptionType type,
            Model model
    ) {
        SubscriptionHandoff handoff = new SubscriptionHandoff();
        handoff.setType(type);

        Set<FeatureType> availableFeatures = subscriptionUtils.getAvailableFeatures(type);
        Set<FeatureType> includedFeatures = subscriptionUtils.getIncludedFeatures(type);

        model.addAttribute("handoff", handoff);
        model.addAttribute("subscriptionType", type);
        model.addAttribute("availableFeatures", availableFeatures);
        model.addAttribute("includedFeatures", includedFeatures);
        model.addAttribute("periods", SubscriptionPeriod.values());

        return "features";
    }


    @PostMapping("/subscriptions/summary")
    public String showSummary(
            @ModelAttribute("handoff") SubscriptionHandoff handoff,
            Model model
    ) {
        SubscriptionResult result =
                subscriptionService.createSubscription(handoff);

        model.addAttribute("subscription", result.getSubscription());
        model.addAttribute("finalPrice", result.getFinalPrice());
        model.addAttribute("handoff", handoff);
        return "summary";
    }

}
