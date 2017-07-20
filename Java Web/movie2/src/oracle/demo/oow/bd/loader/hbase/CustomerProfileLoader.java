package oracle.demo.oow.bd.loader.hbase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import oracle.demo.oow.bd.constant.Constant;
import oracle.demo.oow.bd.dao.hbase.CustomerDAO;
import oracle.demo.oow.bd.to.CustomerTO;

public class CustomerProfileLoader {

	//导入用户数据
    public void uploadProfile() throws IOException {
        FileReader fr = null;
        CustomerDAO custDAO = new CustomerDAO();

        try {
                        
            /**
             * Open the customer.out file for read.
             */
            fr = new FileReader(Constant.CUSTOMER_PROFILE_FILE_NAME);
            BufferedReader br = new BufferedReader(fr);
            String jsonTxt = null;
            String password = Constant.DEMO_PASSWORD;
            CustomerTO custTO = null;
            int count = 1;
            
            /**
             * Loop through the file until EOF. Save the content of each row in
             * the jsonTxt string.
             */
            while ((jsonTxt = br.readLine()) != null) {
                
                if (jsonTxt.trim().length() == 0)
                    continue;
                
                try {
                    /**
                     * Construct the CustomerTO by passing the jsonTxt as an
                     * input argument to its constructor. If the jsonTxt can be
                     * deserialized into CustomerTO then a valid object will be
                     * returned but if it fails to desiralize it for any reason
                     * the null pointer will be returned.
                     */
                    custTO = new CustomerTO(jsonTxt.trim());
                    
                    //Set password to each CutomerTO
                    custTO.setPassword(password);
                } catch (Exception e) {
                    System.out.println("ERROR: Not able to parse the json string: \t" +
                                       jsonTxt);
                }

                /**
                 * Make sure that custTO is not null, which means the jsonTxt
                 * read from the customer.out was successfully converted into
                 * CustomerTO object.
                 */
                if (custTO != null) {
                	custDAO.insertCustomerProfile(custTO);
                    System.out.println(count++ + " " +
                                           custTO.getJsonTxt());

                } //EOF if

            } //EOF while
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fr.close();
        }
    } //uploadProfile

    /**
     * To start loading the data, you need to just run this class. No additional
     * input arguments are required to run this class.
     * @param args
     */
    public static void main(String[] args) {
        CustomerProfileLoader cl = new CustomerProfileLoader();
        try {
            cl.uploadProfile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
