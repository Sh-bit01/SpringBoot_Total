# ProfileControllerApi

All URIs are relative to *http://localhost:9090*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addAllProfiles**](ProfileControllerApi.md#addAllProfiles) | **POST** /profile-manager/profile/all |  |
| [**addProfile**](ProfileControllerApi.md#addProfile) | **POST** /profile-manager/profile |  |
| [**deleteProfileById**](ProfileControllerApi.md#deleteProfileById) | **DELETE** /profile-manager/profile/{id} |  |
| [**getAllProfiles**](ProfileControllerApi.md#getAllProfiles) | **GET** /profile-manager/profile/all |  |
| [**getProfileById**](ProfileControllerApi.md#getProfileById) | **GET** /profile-manager/profile/{id} |  |
| [**getProfileByName**](ProfileControllerApi.md#getProfileByName) | **GET** /profile-manager/profile/name/{name} |  |
| [**updateProfileById**](ProfileControllerApi.md#updateProfileById) | **PUT** /profile-manager/profile/{id} |  |


<a name="addAllProfiles"></a>
# **addAllProfiles**
> List addAllProfiles(Profile)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **Profile** | [**List**](../Models/Profile.md)|  | |

### Return type

[**List**](../Models/Profile.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="addProfile"></a>
# **addProfile**
> Profile addProfile(Profile)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **Profile** | [**Profile**](../Models/Profile.md)|  | |

### Return type

[**Profile**](../Models/Profile.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="deleteProfileById"></a>
# **deleteProfileById**
> Profile deleteProfileById(id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | [default to null] |

### Return type

[**Profile**](../Models/Profile.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="getAllProfiles"></a>
# **getAllProfiles**
> List getAllProfiles()



### Parameters
This endpoint does not need any parameter.

### Return type

[**List**](../Models/Profile.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="getProfileById"></a>
# **getProfileById**
> Profile getProfileById(id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | [default to null] |

### Return type

[**Profile**](../Models/Profile.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="getProfileByName"></a>
# **getProfileByName**
> Profile getProfileByName(name)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**|  | [default to null] |

### Return type

[**Profile**](../Models/Profile.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="updateProfileById"></a>
# **updateProfileById**
> Profile updateProfileById(id, Profile)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | [default to null] |
| **Profile** | [**Profile**](../Models/Profile.md)|  | |

### Return type

[**Profile**](../Models/Profile.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

