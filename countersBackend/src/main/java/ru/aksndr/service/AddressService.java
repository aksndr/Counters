package ru.aksndr.service;

import ru.aksndr.entity.Address;

/**
 * User: a.arzamastsev Date: 29.08.13 Time: 12:00
 */
public interface AddressService {
    public Address getAddressByUserId (long userId);
    public void addAddress(Address address);
}
