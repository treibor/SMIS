package com.smis.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.smis.dbservice.Dbservice;
import com.smis.entity.Scheme;
import com.smis.entity.MasterProcess;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.RolesAllowed;
@PageTitle("Master Data")
@Route(value = "schemeprocess", layout = MainLayout.class)
@RolesAllowed({ "ADMIN", "SUPER" })

public class SchemeProcessView extends VerticalLayout {
    Dbservice service;
    Grid<Scheme> schemegrid = new Grid<>(Scheme.class);
    Grid<MasterProcess> schemeprocessgrid = new Grid<>(MasterProcess.class);
    FormLayout schemeform = new FormLayout();
    boolean isSuperAdmin;

    Button moveUp = new Button("", new Icon(VaadinIcon.ARROW_UP));
    Button moveDown = new Button("", new Icon(VaadinIcon.ARROW_DOWN));
    Button addItem = new Button("Add Item");
    Button save = new Button("Save");
    TextField process = new TextField("New");
    List<MasterProcess> schemeProcesses;

    public SchemeProcessView(Dbservice services) {
        this.service = services;
        isSuperAdmin = services.isSuperAdmin();
        setSizeFull();
        configureGrids();
        configureForms();
        updateGrids();
        add(getToolbar(), getContent());
    }

    private void configureForms() {
        schemeform.setWidth("40%");
        schemeform.add(new HorizontalLayout(moveUp, moveDown), process, addItem, save);

        // Button listeners
        addItem.addClickListener(event -> addNewItem());
        save.addClickListener(event -> saveChanges());
    }

    private void configureGrids() {
        schemegrid.setSizeFull();
        schemegrid.setColumns("schemeName", "schemeDuration", "schemeDept", "schemeLabel");
        schemegrid.addColumn(scheme -> scheme.getSchemeReport()).setHeader("Report Type");
        schemegrid.addColumn(scheme -> scheme.isInUse()).setHeader("In Use");
        schemegrid.addColumn(scheme -> scheme.getDistrict().getDistrictName()).setHeader("District")
                .setSortable(true).setVisible(isSuperAdmin);
        schemegrid.addColumn(scheme -> scheme.getDistrict().getState().getStateName()).setHeader("State")
                .setSortable(true).setVisible(isSuperAdmin);
        schemegrid.asSingleSelect().addValueChangeListener(e -> configureProcessGrid(e.getValue()));
    }

    private void configureProcessGrid(Scheme scheme) {
        schemeprocessgrid.setSizeFull();
        schemeprocessgrid.setColumns("processName", "scheme.schemeName", "stepOrder");
       // schemeprocessgrid.setSortableColumns(null);
        populateProcessGrid(scheme);
    }

    public void populateProcessGrid(Scheme scheme) {
        //schemeprocessgrid.setItems(service.getSchemeProcess(scheme));
    }

    private Component getContent() {
        var hlayout = new HorizontalLayout();
        hlayout.add(schemegrid, schemeprocessgrid, schemeform);
        hlayout.setSizeFull();
        return hlayout;
    }

    private Component getToolbar() {
        Button addButton = new Button("Constituency");
        Button addYear = new Button("Financial Year");
        Button addScheme = new Button("Scheme");
        Button addBlock = new Button("Block");
        addScheme.addClickListener(e -> addScheme());
        return new HorizontalLayout(addButton, addScheme, addBlock, addYear);
    }

    public void updateGrids() {
        schemegrid.setItems(service.getAllSchemesWIthNotInUse());
    }

    private void addScheme() {
        schemegrid.asSingleSelect().clear();
        editScheme(new Scheme());
    }

    private void editScheme(Scheme scheme) {
        //schemeProcesses = new ArrayList<>(service.getSchemeProcess(scheme));
        //schemeprocessgrid.setItems(schemeProcesses);
    }

    private void addNewItem() {
        String processName = process.getValue();
        Scheme scheme=schemegrid.asSingleSelect().getValue();
        int stepOrder=0;
        //service.getMaxStepOrder(scheme)+1;
        if (processName != null && !processName.trim().isEmpty()) {
            MasterProcess newProcess = new MasterProcess();
            newProcess.setProcessName(processName);
            newProcess.setMandatory(true);
            //newProcess.setScheme(scheme);
            newProcess.setStepOrder(stepOrder);
            service.saveSchemeProcess(newProcess);
            populateProcessGrid(scheme);
        } else {
            // Optional: Notify the user that the input is invalid
            Notification.show("Please enter a valid process name.");
        }
    }

    private void saveChanges() {
		/*
		 * schemeProcesses.forEach(process -> { if (process.getId() == null) {
		 * service.saveSchemeProcess(process); // Save new processes } else {
		 * service.updateSchemeProcess(process); // Update existing processes } });
		 */
        Notification.show("Changes saved successfully.");
    }

    private void moveItemUp(Grid<MasterProcess> grid, List<MasterProcess> schemeProcesses) {
        MasterProcess selected = grid.asSingleSelect().getValue(); // Get the selected item
        if (selected != null) {
            int index = schemeProcesses.indexOf(selected);
            if (index > 0) {
                Collections.swap(schemeProcesses, index, index - 1); // Swap with the previous item
                grid.setItems(schemeProcesses); // Refresh the Grid
            }
        }
    }

    private void moveItemDown(Grid<MasterProcess> grid, List<MasterProcess> schemeProcesses) {
        MasterProcess selected = grid.asSingleSelect().getValue(); // Get the selected item
        if (selected != null) {
            int index = schemeProcesses.indexOf(selected);
            if (index < schemeProcesses.size() - 1) {
                Collections.swap(schemeProcesses, index, index + 1); // Swap with the next item
                grid.setItems(schemeProcesses); // Refresh the Grid
            }
        }
    }
}