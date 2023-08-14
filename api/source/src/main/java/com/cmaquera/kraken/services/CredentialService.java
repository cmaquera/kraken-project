package com.cmaquera.kraken.services;

import java.util.List;

import com.cmaquera.kraken.payloads.CredentialDTO;

public interface CredentialService {

    CredentialDTO createCredential(CredentialDTO credentialDTO);

    CredentialDTO getCredentialById(Long id);

    List<CredentialDTO> getAllCredentials();

    CredentialDTO updateCredential(CredentialDTO credentialDTO, Long id);
    
    void removeCredential(Long id);
    
}
