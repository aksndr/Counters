package ru.aksndr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aksndr.dao.AddressDao;
import ru.aksndr.entity.Address;

import java.io.Serializable;

/**
 * User: a.arzamastsev Date: 29.08.13 Time: 12:01
 */
public class AddressServiceImpl implements AddressService, Serializable {

    @Autowired
    public AddressDao addressDao;

    public AddressDao getAddressDao(){
        return addressDao;
    }

    public void setAddressDao(AddressDao addressDao){
        this.addressDao = addressDao;
    }

    @Transactional(readOnly = false)
    @Override
    public Address getAddressByUserId(long userId) {
        return getAddressDao().getAddressByUserId(userId);
    }

    @Transactional(readOnly = false)
    @Override
    public void addAddress(Address address) {
        getAddressDao().addAddress(address);
    }

}
