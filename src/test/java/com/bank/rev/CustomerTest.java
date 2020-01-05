package com.bank.rev;

import com.bank.rev.controller.CustomerController;
import com.bank.rev.dao.gen.tables.pojos.Customer;
import com.bank.rev.service.CustomerService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.javalin.http.Context;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class CustomerTest {
    private CustomerController customerController;
    private CustomerService customerService;
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public CustomerTest() {
        this.customerService = mock(CustomerService.class);
//        this.customerController = new CustomerController(this.customerService);
    }

    @Test
    public void fetchAllCustomerRecordsTest() throws Exception {
        Context context = mock(Context.class);
        CustomerController.fetchAllCustomerRecords.handle(context);
        verify(context).status(200);
    }

    @Test
    public void fetchOneCustomerRecordTest() throws Exception {
        Customer c = new Customer();
        c.setId(1);
        c.setFullName("John Doe");
        c.setEmail("john@email.com");
        c.setPhone("08043452384");

        Context ctx = mock(Context.class);

        doReturn("1").when(ctx).pathParam("id");
        CustomerController.fetchOneCustomerRecord.handle(ctx);
        verify(ctx).status(200);
        // verify(ctx).json(c);

    }

    @Test
    public void createCustomerTest() {
//        Context context = mock(Context.class);
//        this.teapotRequestHandler.handlePostEarlGreyHot(context);
//        verify(context).status(200);
    }

    @Test
    public void updateCustomerTest() {
//        Context context = mock(Context.class);
//        when(this.teapotService.brewEarlGrey(eq(TeapotService.Temperature.COLD))).thenThrow(IllegalArgumentException.class);
//        this.teapotRequestHandler.handlePostEarlGreyCold(context);
//        verify(context).status(400);
    }

}
