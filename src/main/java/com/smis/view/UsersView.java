package com.smis.view;

import com.smis.dbservice.Dbservice;
import com.smis.entity.District;
import com.smis.entity.Users;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@RolesAllowed({"ADMIN", "SUPER"})
@PageTitle("Users")
@Route(value = "users", layout = MainLayout.class)
public class UsersView extends HorizontalLayout {
	Grid<Users> usergrid=new Grid<>(Users.class);
	Dbservice service;
	UsersForm form=new UsersForm(service);
	public UsersView(Dbservice service) {
		this.service=service;
		// TODO Auto-generated constructor stub
		setSizeFull();
		configureForms();
		getUsergrid();
		closeEditor();
		add(getContent());
	}
	private Component getContent() {
		
		HorizontalLayout content=new HorizontalLayout(usergrid, form);
		content.setFlexGrow(1, usergrid);
		content.setFlexGrow(1, form);
		//content.setFlexGrow(1, constiform);
		getUsergrid();
		content.setSizeFull();
		return content;
	}
	public void getUsergrid() {
		usergrid.removeAllColumns();
		usergrid.addColumn(users->users.getUserId()).setHeader("Id").setSortable(true).setResizable(true);
		usergrid.addColumn(users->users.getUserName()).setHeader("User Name").setSortable(true).setResizable(true);
		//usergrid.addColumn(users->users.getRole()).setHeader("Role").setSortable(true).setResizable(true);
		usergrid.addColumn(users->users.isEnabled()).setHeader("Enabled?").setSortable(true).setResizable(true);
		usergrid.addColumn(users->users.getEnteredBy()).setHeader("Entered By").setSortable(true).setResizable(true);
		usergrid.addColumn(users->users.getEnteredOn()).setHeader("Entered On").setSortable(true).setResizable(true);
		usergrid.setItems(service.findUsersByDistrict(service.getLoggedUser().getDistrict()));
		usergrid.asSingleSelect().addValueChangeListener(e->editUser(e.getValue()));
		usergrid.setSizeFull();
		//return usergrid;
	}
	
	private void editUser(Users user) {
		// TODO Auto-generated method stub
		form.setVisible(false);
		if (user == null) {
			form.setVisible(false);
		} else {
			form.setUsers(user);
			form.setVisible(true);
			//yearform.setYear(year);
			
		}
	}
	private void configureForms() {
		form.setVisible(false);
		form=new UsersForm(service);
		form.setWidth("20%");
		form.addListener(UsersForm.SaveEvent.class, this::saveUser);
		
		
	}
	public void saveUser(UsersForm.SaveEvent event) {
		service.saveUser(event.getUsers());
		updateGrids();
		closeEditor();
	}

	private void updateGrids() {
		usergrid.setItems(service.findUsersByDistrict(service.getLoggedUser().getDistrict()));
		
	}
	private void closeEditor() {
		form.setUsers(null);
		form.setVisible(false);

	}
}
