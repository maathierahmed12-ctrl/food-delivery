package Controller;

import Entities.Campaign;
import Services.CampaignManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class Campaigncontroller {



        private CampaignManager campaignManager;

        public void CampaignController(CampaignManager campaignManager) {
            this.campaignManager = campaignManager;
        }

        @PostMapping("/add")
        public String addCampaign(@RequestBody Campaign campaign) {
            return campaignManager.addCampaign(campaign);
        }

        @GetMapping
        public List<Campaign> getAllCampaigns() {
            return campaignManager.getAllCampaigns();
        }
    }

