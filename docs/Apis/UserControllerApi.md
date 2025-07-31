# UserControllerApi

All URIs are relative to *http://localhost:9090*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addAllUsers**](UserControllerApi.md#addAllUsers) | **POST** /user-manager/addAll |  |
| [**addUser**](UserControllerApi.md#addUser) | **POST** /user-manager/user |  |
| [**deleteUserById**](UserControllerApi.md#deleteUserById) | **DELETE** /user-manager/user/{id} |  |
| [**getAllUsers**](UserControllerApi.md#getAllUsers) | **GET** /user-manager/user/all |  |
| [**getUserById**](UserControllerApi.md#getUserById) | **GET** /user-manager/user/{id} |  |
| [**getUserByName**](UserControllerApi.md#getUserByName) | **GET** /user-manager/user/name/{name} |  |
| [**updateUserById**](UserControllerApi.md#updateUserById) | **PUT** /user-manager/user/{id} |  |


<a name="addAllUsers"></a>
# **addAllUsers**
> ResponseListUser addAllUsers(User)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **User** | [**List**](../Models/User.md)|  | |

### Return type

[**ResponseListUser**](../Models/ResponseListUser.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="addUser"></a>
# **addUser**
> ResponseUser addUser(User)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **User** | [**User**](../Models/User.md)|  | |

### Return type

[**ResponseUser**](../Models/ResponseUser.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="deleteUserById"></a>
# **deleteUserById**
> ResponseUser deleteUserById(id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | [default to null] |

### Return type

[**ResponseUser**](../Models/ResponseUser.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="getAllUsers"></a>
# **getAllUsers**
> ResponseListUser getAllUsers()



### Parameters
This endpoint does not need any parameter.

### Return type

[**ResponseListUser**](../Models/ResponseListUser.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="getUserById"></a>
# **getUserById**
> ResponseUser getUserById(id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | [default to null] |

### Return type

[**ResponseUser**](../Models/ResponseUser.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="getUserByName"></a>
# **getUserByName**
> ResponseUser getUserByName(name)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**|  | [default to null] |

### Return type

[**ResponseUser**](../Models/ResponseUser.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="updateUserById"></a>
# **updateUserById**
> ResponseUser updateUserById(id, User)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | [default to null] |
| **User** | [**User**](../Models/User.md)|  | |

### Return type

[**ResponseUser**](../Models/ResponseUser.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

