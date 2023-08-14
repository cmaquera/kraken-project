package com.cmaquera.kraken.services;

import java.util.List;

import com.cmaquera.kraken.payloads.AddressDTO;

public interface AddressService {

    AddressDTO createAddress(AddressDTO addressDTO);

    AddressDTO getAddressById(Long id);

    List<AddressDTO> getAllAddresses();

    AddressDTO updateAddress(AddressDTO addressDTO, Long id);
    
    void removeAddress(Long id);
    
}
