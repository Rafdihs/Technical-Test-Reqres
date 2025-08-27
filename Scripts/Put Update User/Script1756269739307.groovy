import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable

println("PUT to: " + GlobalVariable.BaseURL + "/api/users/" + GlobalVariable.userId)

def response = WS.sendRequest(findTestObject('PUT_UpdateUser'))
WS.verifyResponseStatusCode(response, 200)
println(response.getResponseBodyContent())
println(findTestObject('PUT_UpdateUser').restUrl)

