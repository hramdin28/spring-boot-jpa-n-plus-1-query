package com.programmer.advanced.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Notre controller AdminController contient 2 api, /hello et /hello-admin
 * <p>
 * L'api /hello ne doit être accessible qu'à un utilisateur ayant le rôle USER
 * <p>
 * L'api /hello-admin ne doit être accessible qu'à un utilisateur ayant le rôle ADMIN
 * <p>
 * Implémenter cette sécurité
 */
@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * L'utilisateur ayant le rôle USER doit pouvoir accéder à cette api.
     */
    @WithMockUser(username = "user", roles = "USER")
    @Test
    void should_return_status_0k_when_user_access_hello_api() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/admin/hello"))
              .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * L'utilisateur ayant le rôle ADMIN ne doit pas pouvoir accéder à cette api et doit avoir une
     * erreur 403
     */
    @WithMockUser(username = "admin", roles = "ADMIN")
    @Test
    void should_return_status_403_when_admin_access_hello_api() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/admin/hello"))
              .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    /**
     * L'utilisateur ayant le rôle USER ne doit pas pouvoir accéder à cette api et doit avoir une
     * erreur 403
     */
    @WithMockUser(username = "user", roles = "USER")
    @Test
    void should_return_status_403_when_user_access_hello_admin_api() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/admin/hello-admin"))
              .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    /**
     * L'utilisateur ayant le rôle ADMIN doit pouvoir accéder à cette api.
     */
    @WithMockUser(username = "admin", roles = "ADMIN")
    @Test
    void should_return_status_0k_when_admin_access_hello_admin_api() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/admin/hello-admin"))
              .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
