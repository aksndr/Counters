package ru.aksndr.dao;

import ru.aksndr.entity.Address;

/**
 * User: a.arzamastsev Date: 29.08.13 Time: 11:56
 */
public interface AddressDao {
    public Address getAddressByUserId(long userId);
    public void addAddress(Address address);
}
