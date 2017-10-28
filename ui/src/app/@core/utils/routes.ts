export const API_ROUTES = {

  APPLICATION: {
    MENU: 'api/menu',
  },

  ASSET: {
    GET: 'api/assets.json',
    GET_ID: 'api/asset/', // WITH ID
    SUMMARY: 'api/assetSummary',
    SUMMARY_ID: 'api/assetSummary/', // WITH ID
    SAVE: 'api/asset/submit',
    UPDATE: 'api/asset/update',
    DELETE: 'api/asset/delete/', // WITH ID
  },

  DUMMY: {
    GET_MAINTENANCE: 'api/dummy/maintenances.json',
    SAVE_MAINTENANCE: 'api/dummy/maintenance/submit',
  },

};
