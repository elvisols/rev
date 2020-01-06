package com.bank.rev;

import com.bank.rev.controller.CustomerController;
import com.bank.rev.service.CustomerService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.javalin.http.Context;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Todo: Convert app to Kotlin
 * Testing with Mockito better implemented using Kotlin and 'mockk'
 */
public class CustomerTest {
    private CustomerController customerController;
    private CustomerService customerService;
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public CustomerTest() {
        this.customerService = mock(CustomerService.class);
    }

    @Test
    public void fetchAllCustomerRecordsTest() throws Exception {
        Context context = mock(Context.class);
        CustomerController.fetchAllCustomerRecords.handle(context);
        verify(context).status(200);
    }

    @Test
    public void fetchOneCustomerRecordTest() throws Exception {
        /*
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
        */

    }

    @Test
    public void createCustomerTest() {
    }

    @Test
    public void updateCustomerTest() {
    }

}
