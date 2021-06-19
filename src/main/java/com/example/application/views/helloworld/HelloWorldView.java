package com.example.application.views.helloworld;

import com.example.application.data.AppDTO;
import com.example.application.data.AsyncRestClientService;
import com.example.application.data.RestClientService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Hello World")
public class HelloWorldView extends Main {

    public HelloWorldView(@Autowired RestClientService service) {
        final Grid<AppDTO> appsGrid = new Grid<AppDTO>(AppDTO.class);

        final Button fetchApps = new Button("Fetch All Comments", e -> appsGrid.setItems(service.getAllApps()));
        fetchApps.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(fetchApps, appsGrid);
    }


}
