package com.example.furama.model;

import com.example.furama.model.AttachService;
import com.example.furama.model.Service;

public class ServiceAttachService {
    private Service service;


    private AttachService attachService;

    public ServiceAttachService() {
    }

    @Override
    public String toString() {
        return "ServiceAttachService{" +
                "service=" + service +
                ", attachService=" + attachService +
                '}';
    }

    public ServiceAttachService(Service service, AttachService attachService) {
        this.service = service;
        this.attachService = attachService;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
