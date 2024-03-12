package com.example.furama.model;

public class AttachService {
    private int attachServiceId;

    private String attachServiceName;

    private String attachServiceUnit;

    private Double attachServiceCost;

    @Override
    public String toString() {
        return "AttachService{" +
                "attachServiceId=" + attachServiceId +
                ", attachServiceName='" + attachServiceName + '\'' +
                ", attachServiceUnit='" + attachServiceUnit + '\'' +
                ", attachServiceCost=" + attachServiceCost +
                '}';
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public String getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(String attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public Double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(Double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public AttachService() {
    }

    public AttachService(int attachServiceId, String attachServiceName, String attachServiceUnit, Double attachServiceCost) {
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceCost = attachServiceCost;
    }
}
