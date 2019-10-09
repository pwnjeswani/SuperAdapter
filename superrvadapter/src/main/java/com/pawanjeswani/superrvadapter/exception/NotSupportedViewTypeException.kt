package com.pawanjeswani.superrvadapter.exception

/**
 * For view type exception,
 *
 * We only support 0 and -1 view type options so if  it is other view type, will be throw exception.
 *
 * @property message the error message
 * @constructor create exception with message
 */
class NotSupportedViewTypeException(message: String?) : Exception(message)