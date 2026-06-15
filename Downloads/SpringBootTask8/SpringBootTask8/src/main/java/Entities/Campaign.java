package Entities;

public class Campaign {

    private String campaignId;
    private String CampaignName;
    private String platform;
    private double budget;

    public Campaign(String campaignId,String CampaignName,String platform,double budget){

        this.campaignId=campaignId;
        this.CampaignName=CampaignName;
        this.platform=platform;
        this.budget=budget;

    }
    public String getCampaignId(){
        return campaignId;
    }
    public void setCampaignId(){
        this.campaignId=campaignId;
    }
    public String getCampaignName(){
        return CampaignName;
    }
    public void setCampaignName(){
        this.CampaignName=CampaignName;
    }
    public String getPlatform(){
        return platform;
    }
    public void setPlatform(){

        this.platform=platform;
    }

    public double getBudget(){
        return budget;
    }
    public void setBudget(){
        this.budget=budget;
    }
}


