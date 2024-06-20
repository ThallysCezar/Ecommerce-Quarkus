package dev.thallys.ms.carrinho.service;

import dev.thallys.ms.carrinho.dto.ProdutoDTO;
import dev.thallys.ms.carrinho.dto.UserCartDTO;
import dev.thallys.ms.carrinho.entity.CartItem;
import dev.thallys.ms.carrinho.entity.UserCart;
import dev.thallys.ms.carrinho.repository.CartRepository;
import dev.thallys.ms.carrinho.repository.UserCartRepository;
import dev.thallys.ms.carrinho.utils.UserCartMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.list;

@ApplicationScoped
public class UserCartService {

    @Inject
    UserCartRepository userRepository;

    @Inject
    CartRepository cartRepository;

    @Inject
    UserCartMapper userCartMapper;

    @Transactional
    public List<UserCartDTO> getAll() {
        return userRepository.listAll().stream()
                        .map(fruta -> userCartMapper.toDTO(fruta))
                        .collect(Collectors.toList());
    }

    @Transactional
    public UserCartDTO getById(Long id) {
        return userRepository
                .findByIdOptional(id)
                .map(userCart -> userCartMapper.toDTO(userCart))
                .orElse(null);
    }

    @Transactional
    public List<UserCart> getActiveUsers() {
        return userRepository.findActiveUsers();
    }

    @Transactional
    public List<UserCart> getInactiveUsers() {
        return userRepository.findInactiveUsers();
    }

    @Transactional
    public UserCartDTO createUserCart(UserCartDTO userCartDTO) {
        UserCart userCart = userCartMapper.toEntity(userCartDTO);
        userRepository.persist(userCart);
        if (userRepository.isPersistent(userCart)) {
            return userCartMapper.toDTO(userCart);
        }
        return null;
    }

    @Transactional
    public UserCartDTO updateUserCart(UserCartDTO dto) {
        return userRepository
                .findByIdOptional(dto.getId())
                .map(
                        userCartToUpdate -> {
                            UserCart userCartUpdated = userCartMapper.toEntity(dto);
                            userCartToUpdate.setUserName(userCartUpdated.getUserName());
                            userCartToUpdate.setEmail(userCartUpdated.getEmail());
                            userCartToUpdate.persistAndFlush();
                            return userCartMapper.toDTO(userCartUpdated);
                        })
                .orElse(null);
    }

    @Transactional
    public boolean deleteUserCart(Long userId) {
        return userRepository.deleteById(userId);
    }


    public boolean userExists(Long userId) {
        return userRepository.find("id", userId).firstResultOptional().isPresent();
    }

    public Set<Long> getProductIdsInCart(Long cartId) {
        List<CartItem> cartItems = cartRepository.find("id", cartId).list();
        return cartItems.stream()
                .flatMap(cartItem -> cartItem.getProductIds().stream())
                .collect(Collectors.toSet());
    }

}